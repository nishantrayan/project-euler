(ns problem22)
(def names-content (slurp "src/names-problem22.txt"))
(def matcher (re-matcher #"[A-Z]+" names-content))
(def names (take-while #(not (nil? %))
            (repeatedly #(re-find matcher))))
(def sorted-names (sort names))
(defn alpha-strength
    "computes the alphabetical strength of a string"
    [str]
    (apply + (map #(inc (- (int %) 65)) str)))
(assert (= 6 (alpha-strength "ABC")))
(println (reduce + (for [i (range (count sorted-names))]
                        (* (inc i) (alpha-strength (nth sorted-names i))))))
