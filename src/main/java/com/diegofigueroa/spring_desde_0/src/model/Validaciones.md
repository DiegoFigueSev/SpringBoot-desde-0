# Validaciones más usadas en Spring (Jakarta Validation)

| Anotación        | ¿Para qué sirve?                                      | Parámetros                 | Ejemplo                          |
|------------------|------------------------------------------------------|----------------------------|----------------------------------|
| `@NotNull`       | No permite valores `null`                            | ❌                         | `@NotNull`                       |
| `@NotEmpty`      | No null + no vacío (colecciones, strings)            | ❌                         | `@NotEmpty`                      |
| `@NotBlank`      | No null + no vacío + sin espacios (String)           | ❌                         | `@NotBlank`                      |
| `@Size`          | Tamaño mínimo y/o máximo                            | `min`, `max`              | `@Size(min=3, max=50)`           |
| `@Email`         | Valida formato de email                             | ❌                         | `@Email`                         |
| `@Pattern`       | Valida con expresión regular (regex)                | `regexp`                  | `@Pattern(regexp="\\d+")`        |
| `@Min`           | Valor mínimo (inclusive)                            | `value`                   | `@Min(18)`                       |
| `@Max`           | Valor máximo (inclusive)                            | `value`                   | `@Max(100)`                      |
| `@Positive`      | Número mayor a 0                                    | ❌                         | `@Positive`                      |
| `@PositiveOrZero`| Número mayor o igual a 0                            | ❌                         | `@PositiveOrZero`                |
| `@Negative`      | Número menor a 0                                    | ❌                         | `@Negative`                      |
| `@NegativeOrZero`| Número menor o igual a 0                            | ❌                         | `@NegativeOrZero`                |
| `@Past`          | Fecha en el pasado                                  | ❌                         | `@Past`                          |
| `@Future`        | Fecha en el futuro                                  | ❌                         | `@Future`                        |
| `@AssertTrue`    | El valor debe ser `true`                            | ❌                         | `@AssertTrue`                    |
| `@AssertFalse`   | El valor debe ser `false`                           | ❌                         | `@AssertFalse`                   |

---

## Notas importantes

- Para Strings: usa `@NotBlank` en lugar de `@NotNull`
- Para emails: combina `@Email + @NotBlank`
- Activa validaciones con `@Valid` en el controller
- Puedes combinar múltiples anotaciones en un mismo campo

## Ejemplo

```java
public class UserDTO {

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Email
    @NotBlank
    private String email;

    @Min(18)
    private int age;
}