(ns problem20)
(defn multiply-by-digit
    "multiplies a number in string by a single digit"
    [num-str digit]
    (loop [remaining-num (reverse num-str) carry-so-far 0 product-so-far ""]
        (if (zero? (count remaining-num))
            (apply str carry-so-far (reverse product-so-far))
            (let [product (+ carry-so-far (* digit (Character/digit (first remaining-num) 10)))
                    last-digit (mod product 10)
                    carry (int (/ product 10))]
                (recur (rest remaining-num)
                        carry
                        (str product-so-far last-digit))))))
(assert (= "0246" (multiply-by-digit "123" 2)))
(assert (= "891" (multiply-by-digit "99" 9)))
(defn add-numbers
    "adds 2 number in string and returns result in string"
    [num1-str num2-str]
    (loop [num1-remain (reverse num1-str) num2-remain (reverse num2-str) sum-so-far "" carry-so-far 0]
        (if (zero? (count num1-remain))
            (apply str carry-so-far (reverse sum-so-far))
            (let [sum (+ carry-so-far (Character/digit (first num1-remain) 10) (Character/digit (first num2-remain) 10))
                    last-digit (mod sum 10)
                    carry (int (/ sum 10))]
                (recur (rest num1-remain)
                        (rest num2-remain)
                        (str sum-so-far last-digit)
                        carry)))))
(assert (= "1110" (add-numbers "999" "111")))
(assert (= "02" (add-numbers "1" "1")))
(defn add-normalized-numbers
    "adds the numbers after normalizing their lengths"
    [num1-str num2-str]
    (let [max-len (max (count num1-str) (count num2-str))
            norm-fn (fn [x](apply str (apply str (repeat (- max-len (count x)) "0")) x))
            num1-norm (norm-fn num1-str)
            num2-norm (norm-fn num2-str)]
        (add-numbers num1-norm num2-norm)))
(assert (= "022" (add-normalized-numbers "1" "21")))
(assert (= "10000" (add-normalized-numbers "1" "9999")))
(defn multiply-by-number
    "multiplies a number in string by another number"
    [num1-str num2]
    (loop [num2-remain num2 sum-so-far (apply str (repeat (inc (count num1-str)) "0"))]
        (if (zero? num2-remain)
            sum-so-far
            (let [product (multiply-by-digit num1-str (mod num2-remain 10))
                    zeroes-to-append (- (count (str num2)) (count (str num2-remain)))
                    result-sum (add-normalized-numbers (str product (apply str (repeat zeroes-to-append "0"))) sum-so-far)]
                (recur (int (/ num2-remain 10))
                        result-sum)))))

(assert (= "0022" (multiply-by-number "11" 2)))
(assert (= "019980" (multiply-by-number "999" 20)))
(assert (= "002" (multiply-by-number "1" 2)))

(println (reduce + (map #(Character/digit % 10)
    (loop [num 1 product-so-far "1"]
            (if (= num (inc 100))
                product-so-far
                (recur (inc num)
                        (multiply-by-number product-so-far num)))))))