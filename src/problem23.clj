(ns problem23)
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
(defn abundant?
    "returns true if sum of proper divisors > number"
    [n]
    (> (proper-divisors n) n))
(def abundant-numbers (filter abundant? (range 2 28124)))
(def abundant-bool (boolean-array  28124))
(doseq [abundant-number abundant-numbers]
        (aset abundant-bool abundant-number true))
(assert (aget abundant-bool 24))
(assert (aget abundant-bool 78))
(assert (not (aget abundant-bool 71)))
(defn abundant-sum?
    "returns true if the number can't be written as sum of abundant numbers"
    [n]
        (do (println n)
        (let [  filtered-abundant-numbers
                            (take-while #(< % n) abundant-numbers)
                abundant-sums
                            (for [abundant-number filtered-abundant-numbers]
                                (aget abundant-bool (- n abundant-number)))]
            (if (zero? (count abundant-sums))
                false
                (reduce (fn [x y] (or x y)) abundant-sums)))))
(println (reduce + (filter #(not (abundant-sum? %)) (range 28124))))

