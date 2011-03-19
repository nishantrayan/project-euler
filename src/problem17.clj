(ns problem17)
(def unit ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten"])
(def hundred ["zero" "ten" "twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"])
(def tens ["ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"])

(defn count-letters
    "returns the number of letters used in the number written as words"
    [number]
    (if (zero? number)
        ""
        (let [significant (Character/digit (first (str number)) 10)
                rest-number (if (< number 20) 0 (Integer/parseInt (apply str (rest (str number)))))
                current
                        (if (>= number 100)
                            (if (= number 1000) "onethousand"
                            (str (nth unit significant) "hundred" (if (zero? rest-number) "" "and")))
                            (if (>= number 20)
                                (str (nth hundred significant))
                                (if (>= number 10)
                                    (str (nth tens (- number 10)))
                                    (str (nth unit number)))))]
            (str current (count-letters rest-number)))))
;(println (map #(str % ":" (count-letters %) "\n") (range 1 1001)))
(println (reduce + (map #(count (count-letters %)) (range 1 1001))))

