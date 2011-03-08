(ns problem3)
(defn divide-number-repeat
    "divides a number by a divisor until possible"
    [number divisor]
        (loop [current number]
            (if (not (zero? (rem current divisor)))
                    current
                        (recur (/ current divisor)))))
(assert (= 9 (divide-number-repeat (* 3 3 2 2 2 2 2 2 2 2 2) 2)))
(defn find-prime-factors
    "finds largest prime factor of a number"
    [n]
    (loop [current n divisor 2]
        (let [what-is-left (divide-number-repeat current divisor)]
            (if (= 1 what-is-left)
                divisor
                    (recur what-is-left (inc divisor))))))
(println (find-prime-factors 600851475143))
