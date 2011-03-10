(ns problem6)
(defn find-difference
    "finds the difference between sum squares of numbers and square of sum of numbers in the range"
    [num-range]
            (- (int (Math/pow (reduce + num-range) 2))
                (reduce + (map (fn [n] (* n n)) num-range))))
(println (find-difference (range 1 (inc 100))))

