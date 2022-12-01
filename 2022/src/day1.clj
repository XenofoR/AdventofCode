(ns day1
    (:require [inputUtils :as utils]))

(def input (utils/getListFromFile "../resources/day1.input"))


(defn calculate-sums [remainingValues currentSum allSums]
    (if (empty? remainingValues) allSums
                                 (if (= (first remainingValues) "")
                                     (calculate-sums (rest remainingValues) 0 (conj allSums currentSum))
                                     (calculate-sums (rest remainingValues) (+ currentSum (Integer/parseInt (first remainingValues))) allSums)))
    )

(def output (sort > (calculate-sums input 0 (empty list))))
(println (reduce + (take 3 output)))