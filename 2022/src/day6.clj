(ns day6
  (:require [inputUtils :as utils]
            [clojure.string :as str]))

(def input (reduce conj (utils/getListFromFile "../resources/day6.input")))
;;(def input "mjqjpqmgbljsphdztnvjfqwrcgsmlb")


(defn recursive-marker-search [jumpLength remainingChars currentPosition]
  (if (> jumpLength (count (set (take jumpLength remainingChars)))) (recursive-marker-search jumpLength (rest remainingChars) (inc currentPosition)) currentPosition)
  )

;;(println (recursive-marker-search 4 (utils/stringToCharVector input) 4)) 1 star
(println (recursive-marker-search 14 (utils/stringToCharVector input) 14))