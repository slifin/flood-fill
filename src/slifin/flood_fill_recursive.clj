(ns slifin.flood-fill-recursive)

(defn pixel [img x y] (get-in img [x y]))

(defn flood-loop [img x y colours size]
  (let [dot (pixel img x y)]
    (if (or (< x 0)
            (< y 0)
            (>= x (:x size))
            (>= y (:y size))
            (not= dot (:old colours))
            (= dot (:new colours)))
      img
      (-> img
        (assoc-in [x y] (:new colours))
        (flood-loop (inc x) y colours size)
        (flood-loop (dec x) y colours size)
        (flood-loop x (inc y) colours size)
        (flood-loop x (dec y) colours size)))))

(defn flood-fill [img x y new-colour]
  (let [size {:x (count (get img 0))
              :y (count img)}
        colours {:old (pixel img x y)
                 :new new-colour}]
    (flood-loop img x y colours size)))
