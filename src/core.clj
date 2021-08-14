(ns core
  (:require [cljls.core :refer :all]))

(defn -main
  [& args]
  (if (empty? args)
    (ls ".")
    (ls (first args))))
