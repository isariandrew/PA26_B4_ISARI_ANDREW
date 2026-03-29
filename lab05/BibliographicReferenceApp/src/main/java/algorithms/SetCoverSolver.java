package algorithms;

import models.BibliographicReferences;

import java.util.*;

public final class SetCoverSolver {

    public static class CoverResult {
        private final List<BibliographicReferences> cover;
        private final Set<String> coveredConcepts;
        private final Set<String> uncoveredConcepts;
        private final long elapsedNanos;

        public CoverResult(List<BibliographicReferences> cover,
                           Set<String> coveredConcepts,
                           Set<String> uncoveredConcepts,
                           long elapsedNanos) {
            this.cover = Collections.unmodifiableList(cover);
            this.coveredConcepts = Collections.unmodifiableSet(coveredConcepts);
            this.uncoveredConcepts = Collections.unmodifiableSet(uncoveredConcepts);
            this.elapsedNanos = elapsedNanos;
        }

        public List<BibliographicReferences> getCover()        { return cover; }
        public Set<String> getCoveredConcepts()                 { return coveredConcepts; }
        public Set<String> getUncoveredConcepts()               { return uncoveredConcepts; }
        public long getElapsedNanos()                           { return elapsedNanos; }
        public double getElapsedMs()                            { return elapsedNanos / 1_000_000.0; }
        public boolean isComplete()                             { return uncoveredConcepts.isEmpty(); }

        public void print(String label) {
            System.out.println("--- " + label + " ---");
            System.out.println("Complete cover: " + isComplete());
            System.out.println("References selected: " + cover.size());
            for (BibliographicReferences ref : cover) {
                System.out.println("  [" + ref.getId() + "] concepts=" + ref.getConcepts());
            }
            if (!uncoveredConcepts.isEmpty()) {
                System.out.println("Uncovered concepts: " + uncoveredConcepts);
            }
            System.out.printf("Time: %.3f ms%n", getElapsedMs());
            System.out.println();
        }
    }

    private SetCoverSolver() {}

    public static CoverResult greedy(Collection<BibliographicReferences> references,
                                     Set<String> universe) {
        long t0 = System.nanoTime();

        Set<String> uncovered = new LinkedHashSet<>(universe);
        List<BibliographicReferences> selected = new ArrayList<>();
        Set<BibliographicReferences> remaining = new LinkedHashSet<>(references);

        while (!uncovered.isEmpty() && !remaining.isEmpty()) {
            BibliographicReferences best = null;
            int bestGain = 0;

            for (BibliographicReferences ref : remaining) {
                int gain = intersectionSize(ref.getConcepts(), uncovered);
                if (gain > bestGain) {
                    bestGain = gain;
                    best = ref;
                }
            }

            if (best == null || bestGain == 0) {
                break;
            }

            selected.add(best);
            remaining.remove(best);
            uncovered.removeAll(best.getConcepts());
        }

        long elapsed = System.nanoTime() - t0;
        Set<String> covered = new LinkedHashSet<>(universe);
        covered.removeAll(uncovered);

        return new CoverResult(selected, covered, uncovered, elapsed);
    }

    public static final int MAX_EXACT_SIZE = 25;

    public static CoverResult exact(Collection<BibliographicReferences> references,
                                    Set<String> universe) {
        List<BibliographicReferences> refList = new ArrayList<>(references);
        int n = refList.size();

        if (n > MAX_EXACT_SIZE) {
            throw new IllegalArgumentException(
                    "Exact solver is capped at " + MAX_EXACT_SIZE +
                            " references (got " + n + "). Use the greedy solver instead.");
        }

        long t0 = System.nanoTime();

        List<String> conceptList = new ArrayList<>(universe);
        Map<String, Integer> conceptIndex = new HashMap<>();
        for (int i = 0; i < conceptList.size(); i++) {
            conceptIndex.put(conceptList.get(i), i);
        }

        long universeMask = (1L << conceptList.size()) - 1;

        long[] refMasks = new long[n];
        for (int i = 0; i < n; i++) {
            long mask = 0L;
            for (String c : refList.get(i).getConcepts()) {
                Integer idx = conceptIndex.get(c);
                if (idx != null) {
                    mask |= (1L << idx);
                }
            }
            refMasks[i] = mask;
        }

        int bestSize = n + 1;
        long bestSubset = 0;

        outer:
        for (int k = 1; k <= n && k < bestSize; k++) {
            int[] indices = new int[k];
            for (int i = 0; i < k; i++) indices[i] = i;

            while (true) {
                long union = 0L;
                long subsetBits = 0L;
                for (int idx : indices) {
                    union |= refMasks[idx];
                    subsetBits |= (1L << idx);
                }

                if ((union & universeMask) == universeMask) {
                    bestSize = k;
                    bestSubset = subsetBits;
                    break outer;
                }

                if (!nextCombination(indices, n)) break;
            }
        }

        long elapsed = System.nanoTime() - t0;

        List<BibliographicReferences> selected = new ArrayList<>();
        Set<String> covered = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            if ((bestSubset & (1L << i)) != 0) {
                selected.add(refList.get(i));
                for (String c : refList.get(i).getConcepts()) {
                    if (universe.contains(c)) covered.add(c);
                }
            }
        }

        Set<String> uncovered = new LinkedHashSet<>(universe);
        uncovered.removeAll(covered);

        return new CoverResult(selected, covered, uncovered, elapsed);
    }

    private static int intersectionSize(Set<String> a, Set<String> b) {
        if (a.size() > b.size()) {
            return intersectionSize(b, a);
        }
        int count = 0;
        for (String s : a) {
            if (b.contains(s)) count++;
        }
        return count;
    }

    private static boolean nextCombination(int[] indices, int n) {
        int k = indices.length;
        int i = k - 1;
        while (i >= 0 && indices[i] == n - k + i) {
            i--;
        }
        if (i < 0) return false;
        indices[i]++;
        for (int j = i + 1; j < k; j++) {
            indices[j] = indices[j - 1] + 1;
        }
        return true;
    }
}