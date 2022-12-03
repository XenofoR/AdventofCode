(ns day3
  (:require [inputUtils :as utils])
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(def input (utils/getListFromFile "../resources/day3.input"))
(def  values {"a" 1 "b" 2 "c" 3 "d" 4 "e" 5 "f" 6 "g" 7 "h" 8 "i" 9 "j" 10 "k" 11 "l" 12 "m" 13 "n" 14 "o" 15 "p" 16 "q" 17 "r" 18 "s" 19 "t" 20 "u" 21 "v" 22 "w" 23 "x" 24 "y" 25 "z" 26
      "A" 27 "B" 28 "C" 29 "D" 30 "E" 31 "F" 32 "G" 33 "H" 34 "I" 35 "J" 36 "K" 37 "L" 38 "M" 39 "N" 40 "O" 41 "P" 42 "Q" 43 "R" 44 "S" 45 "T" 46 "U" 47 "V" 48 "W" 49 "X" 50 "Y" 51 "Z" 52})


(defn map-mid-split [toSplit]
  (def length (count toSplit))
  {1 (set (subs toSplit 0 (/ length 2)))
   2 (set (subs toSplit  (/ length 2) length))
   })

(defn intersect-tuple [tuple]
  (set/intersection (get tuple 1) (get tuple 2)))

(defn recursive-intersect [remaining uniqueItems]
  (def current-split (map set (first remaining)))
  (def stringRepresentation (map str (reduce set/intersection current-split)))
  (def increment (+ uniqueItems (get values (first stringRepresentation))))
  (if (empty? (rest remaining)) increment
                                (recursive-intersect (rest remaining) increment))
  )

(def split (map map-mid-split input))
(def uniqueItems (map first (map intersect-tuple split)))

(println (reduce + (map #(get values %) (map str uniqueItems)))) ;;1 star
(println (recursive-intersect  (partition 3 input) 0))      ;;2 star