(ns problem16)
(defn multiply-by-2
    "multiplies a number (as string) by 2 and returns the result as string"
    [num-string carry-so-far]
        (let [last-digit (Integer/parseInt (str (last num-string)))
                product-last-digit (+ carry-so-far (* last-digit 2))
                remainder (mod product-last-digit 10)
                carry (int (/ product-last-digit 10))]
        (if (= (count num-string) 1)
            (str product-last-digit)
            (str (multiply-by-2 (.substring num-string 0
                                            (dec (count num-string)))
                                carry)
                  remainder))))
(def power-2-1000 (nth (iterate #(multiply-by-2 % 0) "1") 1000))
(def matcher (re-matcher #"[0-9]" power-2-1000))
(println (apply + (map #(Integer/parseInt (str %))
                        (take-while #(not (nil? %))
                                    (repeatedly #(re-find matcher))))))


