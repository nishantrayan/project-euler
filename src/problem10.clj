(ns problem10)
(defn is-prime?
    "checks if a number is prime and returns true if its prime"
    [n]
    (let [limit (Math/ceil (Math/sqrt n))]
        (if (= n 2) true
            (if(= n 1) false
                        (loop [current 2]
                            (if (> current limit)
                                true
                                (if (zero? (rem n current))
                                    false
                                        (recur (inc current)))))))))
(println (apply + (filter is-prime? (range 1 2000000))))
