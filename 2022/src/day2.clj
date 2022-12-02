(ns day2
  (:require [inputUtils :as utils]))

(def input (utils/getListFromFile "../resources/day2.input"))
(def rule1 {"A X" 4 "A Y" 8 "A Z" 3 "B X" 1 "B Y" 5 "B Z" 9 "C X" 7 "C Y" 2 "C Z" 6})
(def rule2 {"A X" 3 "A Y" 4 "A Z" 8 "B X" 1 "B Y" 5 "B Z" 9 "C X" 2 "C Y" 6 "C Z" 7})

(defn one-star [game]
  (get rule1 game)
  )

(defn two-star [game]
  (get rule2 game)
  )

(def play1 (map one-star input))
(def play2 (map two-star input))

(println (reduce + play1))
(println (reduce + play2))


