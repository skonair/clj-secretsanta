(ns clj-secretsanta.core)


(def people [
	{:vorname "Luke" :nachname "Skywalker"}
	{:vorname "Leia" :nachname "Skywalker"}
	{:vorname "Toula" :nachname "Portokalos"}
	{:vorname "Gus" :nachname "Portokalos"}
	{:vorname "Bruce" :nachname "Wayne"}
	{:vorname "Virgil" :nachname "Brigman"}
	{:vorname "Lindsey" :nachname "Brigman"}
	{:vorname "John" :nachname "Doe"}
	{:vorname "Jane" :nachname "Doe"}
	{:vorname "Bobba" :nachname "Fett"}
	{:vorname "Anakin" :nachname "Skywalker"}	
	])


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
	(first (filter valid? (map #(let [fst (first %) cs (conj (vec %) fst)] (partition 2 1 cs)) (permutations c)))))



(defn to-string [c]
	(loop [[t & ts] c akk (str (:vorname (first t)) " " (:nachname (first t)) )]
		(if (nil? t)
			akk
			(recur ts (str akk " -> " (:vorname (second t)) " " (:nachname (second t)))))
		))

(defn to-tuples [s]
       (let [fst (first s) c (conj (vec s) fst)]
               (loop [[a & as] c akk []]
                       (if (nil? as)
                               akk
                               (recur as (conj akk [a (first as)]))))))

(defn secret-santa-2 [c]
	(first (filter valid? (map to-tuples (permutations c)))))
