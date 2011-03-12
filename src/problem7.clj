(ns problem7)
(defn is-prime?
    "checks if a number is prime and returns true if its prime"
    [n]
    (let [limit (Math/ceil (Math/sqrt n))]
        (loop [current 2]
            (if (> current limit)
                true
                (if (zero? (rem n current))
                    false
                        (recur (inc current)))))))
(assert (not (is-prime? 12)))
(assert (is-prime? 11))
(assert (is-prime? 73))
(defn next-prime
    "finds the next prime number given the last known one"
    [n]
    (let [next-n (inc n)]
        (if (is-prime? next-n)
            next-n
            (recur next-n))))
(assert (= 11 (next-prime 7)))
(assert (= 13 (next-prime 11)))
(assert (= 23 (next-prime 19)))
(println (nth (iterate next-prime 2) (dec 10001)))
