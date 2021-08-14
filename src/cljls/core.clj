(ns cljls.core
  (:require [clojure.string :as str])
  (:import [java.io File]))

(defn list-file-name
  [path]
  (->> (.listFiles (File. ^String path))
       (filter #(not (.isHidden %)))
       (sort-by #(.toString %))
       (map #(.getName %))))

(defn add-space-padding
  [file-names]
  (let [word-count (->> file-names
                        (sort-by count)
                        last
                        count)]
    (->> file-names
         (map #(format (str "%-" word-count "s") %)))))

(defn ls
  [path]
  (->> path
       list-file-name
       add-space-padding
       (str/join " ")
       str/trim
       println))
