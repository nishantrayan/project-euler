(ns problem4)
;(defn find-palindrome
;    "finds the largest palindrome product of two 3-digit numbers"
(defn palin?
    "Checks if a number is palindrome"
    [n]
    (= (list n) (reverse (list n))))
(println (reduce max
            (filter palin?
                (mapcat
                    (fn [n] (map (partial * n) (range 100 999)))
                    (range 100 999)))))

