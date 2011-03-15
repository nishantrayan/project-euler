(ns problem12)
(defn count-factors
    "returns the number of unique factors that the number has"
    [n]
    (let [sq (Math/sqrt n) limit (int (Math/floor sq))]
        (loop [current 1 count-divisors 0]
            (if (> current limit)
                count-divisors
                (recur (inc current)
                        (+ count-divisors
                            (if (zero? (mod n current))
                                (if (= current sq)
                                    1 2)
                                0)))))))
(assert (= (count-factors 5) 2))
(assert (= (count-factors 6) 4))
(assert (= (count-factors 9) 3))
(assert (= (count-factors 16) 5))

(println (loop [current 1 sum 0]
    (if (> (count-factors sum) 500)
        sum
        (recur (inc current)
                (+ sum current)))))

