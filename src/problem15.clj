(ns problem13)
(def memo (long-array (* 21 21)))
(defn find-combination
    "finds the unique combinations using n1 horizontal and n2 vertical lines"
    [n1 n2]
    (let [min-n (min n1 n2) max-n (max n1 n2) memo-index (+ (* min-n 20) max-n) ans-in-memo (aget memo memo-index)]
        (if (zero? ans-in-memo)
            (if (= min-n 1)
                (inc max-n)
                (let [combinations (+ (find-combination (dec n1) n2)
                                     (find-combination n1 (dec n2)))]
                    (do (aset-long memo memo-index combinations)
                        combinations)))
            ans-in-memo)))

(println (find-combination 20 20))

