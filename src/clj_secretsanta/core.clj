(ns clj-secretsanta.core)

(defn permutations [c]
	(lazy-seq
		(if (seq (rest c))
			(apply concat (for [x c]
				(map #(cons x %) (permutations (remove #{x} c))))) [c])))

(defn valid? [c] 
	(loop [[t & ts] c b true]
		(if (nil? t) 
			b
			(recur ts (and b (not (= (:nachname (first t)) (:nachname (second t)))))))))

(defn secret-santa [c]
	(first (filter valid? (map #(partition 2 1 (take (inc (count %)) (cycle %))) (permutations c)))))

