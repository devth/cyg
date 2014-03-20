# cyg

Minimalist configuration. Expects a `config.edn` or `config.clj` path to be
available as a resource. Use Leiningen profiles to specify how config gets on
the resource paths.

**Warning**: wet paint. A companion lein plugin is planned to help with config
setup.

```clojure
[cyg "0.1.0"]
```

## Usage

```clojure
(require '[cyg.core :refer [cf]])

(if-let [qux (cf :foo :bar :baz :qux)]
  (println "found config" qux")
  (println "config is not set"))
```

With this configuration on resource path:

```
;; config.edn
{:foo {:bar {:baz {:qux "hi cyg!"}}}}
```

The above example would print `hi cyg`.

## License

Copyright © 2014 Trevor Hartman

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
