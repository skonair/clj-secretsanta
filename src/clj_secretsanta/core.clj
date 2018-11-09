(ns clj-secretsanta.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(def people [
	{:vorname "Luke" :nachname "Skywalker"}
	{:vorname "Leia" :nachname "Skywalker"}
	{:vorname "Toula" :nachname "Portokalos"}
	{:vorname "Gus" :nachname "Portokalos"}
	])


(defn permutations [c]
	(lazy-seq
		(if (seq (rest c))
			(apply concat (for [x c]
				(map #(cons x %) (permutations (remove #{x} c)))))
			[c])))

(defn to-tuples [s]
	(let [c (vec (conj s (first s)))]
		(loop [[a & as] c akk []]
			(if (empty? as)
				akk
				(recur as (conj akk [a (first as)]))))))

(defn valid? [c] 
	(println "valid? c is " c)
	(loop [[[t1 t2] as t & ts] c b true]
		(println " t is " t)
		(println "t1 is " t1 " t2 is " t2)
		(if (nil? t) 
			b
			(recur ts (and b (not (= (:nachname t1) (:nachname t2))))))))
