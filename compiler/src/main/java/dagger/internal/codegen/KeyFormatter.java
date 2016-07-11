/*
 * Copyright (C) 2014 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.internal.codegen;

/**
 * Formats a {@link Key} into a {@link String} suitable for use in error messages and JSON keys.
 *
 * @author Christian Gruber
 * @since 2.0
 */
final class KeyFormatter extends Formatter<Key> {
  
  final MethodSignatureFormatter methodSignatureFormatter;

  KeyFormatter(MethodSignatureFormatter methodSignatureFormatter) {
    this.methodSignatureFormatter = methodSignatureFormatter;
  }

  @Override
  public String format(Key key) {
    if (key.bindingIdentifier().isPresent()) {
      // If there's a binding identifier, use that.
      return key.bindingIdentifier().get().toString();
    }
    StringBuilder builder = new StringBuilder();
    if (key.qualifier().isPresent()) {
      builder.append(key.qualifier().get());
      builder.append(' ');
    }
    builder.append(key.type());
    return builder.toString();
  }
}
