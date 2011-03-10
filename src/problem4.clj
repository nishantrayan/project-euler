(ns problem4)
(defn palin?
    "Checks if a number is palindrome"
    [n]
    (= (str n) (apply str (reverse (str n)))))
(println (reduce max
            (filter palin?
                (mapcat
                    (fn [n] (map (partial * n) (range n 1000)))
                    (range 100 1000)))))

