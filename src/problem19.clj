(ns problem19)
(defn leap-year?
    "returns true if the year is leap year"
    [year]
    (if (zero? (mod year 100))
        (if (zero? (mod year 400))
            true false)
        (if (zero? (mod year 4))
            true false)))
(assert (not (leap-year? 1941)))
(assert (leap-year? 1944))

(def month-days [0 31 28 31 30 31 30 31 31 30 31 30 31])
(defn number-of-days
    "returns the number of days in a given month/year"
    [month year]
    (if (and (leap-year? year) (= month 2))
        29
        (nth month-days month)))
(assert (= (number-of-days 1 1999) 31))
(assert (= (number-of-days 2 1999) 28))
(assert (= (number-of-days 2 1992) 29))
(defn add-days
    "adds some x number of days to the current weekday and returns the resulting weekday"
    [weekday days-to-add]
    (inc (mod (+ (dec weekday) days-to-add) 7)))
(assert (= (add-days 1 7) 1))
(assert (= (add-days 7 7) 7))
(assert (= (add-days 7 8) 1))
(def start-day (add-days 1 (reduce + (for [month (range 1 13)] (number-of-days month 1900)))))

(println
    (count
        (filter #(= % 7) (for [year (range 1901 2001) month (range 1 13)]
                        (let [passed-days (+ (reduce +
                                                    (for [passed-year (range 1901 year) passed-month (range 1 13)]
                                                        (number-of-days passed-month passed-year)))
                                            (reduce + (for [passed-month (range 1 month)]
                                                            (number-of-days passed-month year))))]
                            (add-days start-day passed-days))))))