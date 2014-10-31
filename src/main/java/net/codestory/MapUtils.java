/**
 * Copyright (C) 2013 all@code-story.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package net.codestory;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

class MapUtils {
  private MapUtils() {
    // Static class
  }

  static <T, K, V> Map<K, V> toMap(Iterable<T> values, Function<? super T, K> toKey, Function<? super T, V> toValue, Supplier<? extends Map<K, V>> mapSupplier) {
    requireNonNull(toKey);
    requireNonNull(toValue);

    Map<K, V> map = mapSupplier.get();

    values.forEach(item -> {
      K key = toKey.apply(item);
      V value = toValue.apply(item);
      if (null != map.put(key, value)) {
        throw new IllegalArgumentException("Same key used twice " + key + " " + value);
      }
    });

    return map;
  }

  static <T, K, V> Map<K, V> toLenientMap(Iterable<T> values, Function<? super T, K> toKey, Function<? super T, V> toValue, Supplier<? extends Map<K, V>> mapSupplier) {
    requireNonNull(toKey);
    requireNonNull(toValue);

    Map<K, V> map = mapSupplier.get();

    values.forEach(item -> {
      K key = toKey.apply(item);
      V value = toValue.apply(item);
      map.put(key, value);
    });

    return map;
  }
}
