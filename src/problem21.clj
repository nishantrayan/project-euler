(ns problem21)
(defn proper-divisors
    "returns the sum of proper divisors of a number"
    [n]
    (inc (apply +
            (for [i (range 2 (inc (int (Math/floor (Math/sqrt n)))))]
                (if (= (* i i) n)
                    i
                    (if (zero? (mod n i))
                        (+ i (int (/ n i)))
                        0))))))
(assert (= 6 (proper-divisors 6)))
(assert (= 220 (proper-divisors 284)))
(defn amicable-number?
    "returns true if the number is amicable"
    [n]
    (let [p-div (proper-divisors n)]
        (and (not (= n p-div)) (= (proper-divisors p-div) n))))
(println (apply + (filter amicable-number? (range 2 10001))))
