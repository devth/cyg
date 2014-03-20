# cyg

Minimalist configuration. Expects a `config.edn` or `config.clj` path to be
available as a resource. Use Leiningen profiles to specify how config gets on
the resource paths.

**Warning**: wet paint.

```clojure
[cyg "0.1.4"]
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

## TODO

- A companion lein plugin to help with config setup.
- By default, cyg should setup `config/:profile` resource-paths for `dev`
  and `prod`, so if you place `config.edn` at `config/dev/config.edn` cyg will
  load it when the Leiningen `dev` profile is active.

## License

Copyright © 2014 Trevor Hartman

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
