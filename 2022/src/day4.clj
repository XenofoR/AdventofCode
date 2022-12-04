(ns day4
  (:require [inputUtils :as utils]
            [clojure.string :as str]
            [clojure.set :as set]))

(def input (utils/getListFromFile "../resources/day4.input"))

(def split (map #(str/split % #",") input))

;;This got really ugly just because range will return empty if start and end is the same value
;;maybe there is a prettier way, but its late and I need some sleep
(defn createRanges [vector]
  (def firstVal (map #(Integer/parseInt %) (str/split (nth vector 0) #"-")))
  (def secondVal (map #(Integer/parseInt %) (str/split (nth vector 1) #"-")))
  (map set (list (if (= (nth firstVal 0) (nth firstVal 1))
                   (list (nth firstVal 0))
                   (range (nth firstVal 0) (+ 1 (nth firstVal 1))))
                 (if (= (nth secondVal 0) (nth secondVal 1))
                   (list (nth secondVal 0))
                   (range (nth secondVal 0) (+ 1 (nth secondVal 1)))
                   )
                 )
       )
  )

(defn compareRanges [ranges]
  (or (set/subset? (nth ranges 0) (nth ranges 1)) (set/subset? (nth ranges 1) (nth ranges 0)))
  )

(defn intersectRanges [ranges]
  (empty? (set/intersection (nth ranges 0) (nth ranges 1))))

(println (count (filter true? (map compareRanges (map createRanges split))))) ;;1 star

(println (count (filter false? (map intersectRanges (map createRanges split))))) ;;2 star
