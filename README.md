Гарчиг: Лаборатори №9 — Код хамралт ба JaCoCo

- Хичээл: F.CSA313 — Программ хангамжийн чанарын баталгаа ба тест
- Оюутан: Л. Ирмүүн
- Оюутны код: B232270021
- Үйлдлийн систем: Ubuntu Linux
- IDE: Visual Studio Code

А=== java -version ===
openjdk version "21.0.12.1" 2026-08-18
OpenJDK Runtime Environment (build 21.0.12.1+1-1-24.04.4-Ubuntu)
OpenJDK 64-Bit Server VM (build 21.0.12.1+1-1-24.04.4-Ubuntu, mixed mode, sharing)

=== mvn -version ===
[1mApache Maven 3.8.7[m
Maven home: /usr/share/maven
Java version: 21.0.12.1, vendor: Ubuntu, runtime: /usr/lib/jvm/java-21-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "7.0.0-42-generic", arch: "amd64", family: "unix"

=== locale charmap ===
UTF-8

## Хэсэг A — Хэвийн урсгал ба анхны хамралт

Хэвийн оролтын 5 тестүүдийг `mvn verify` командаар ажиллуулахад
бүгд амжилттай давж, Maven exit code 0 гарсан.

| Хэмжүүр | Хамрагдсан | Хамрагдаагүй | Хамралт |
|---|---:|---:|---:|
| Line | 17 | 8 | 68.00% |
| Branch | 24 | 17 | 58.54% |

Line хамралт: 17 / (8 + 17) × 100 = 68.00%.
Branch хамралт: 24 / (17 + 24) × 100 ≈ 58.54%.

`scholarship()`-ийн `if (gpa < 0 || gpa > 4 || credits < 0)`
мөрийн шар ромбо нь зургаан салааны гурав хамрагдаагүйг харуулсан.
Хэвийн оролтууд гурван нөхцөлийн худал утгыг хамарсан боловч
буруу оролтоор exception үүсэх замуудыг шалгаагүй байна.
`if (gpa >= 3.0) return 50;` мөрийн улаан ромбо нь хоёр салаа
хоёулаа хамрагдаагүй буюу тестүүд энэ шийдвэрт хүрээгүйг харуулсан.

Нотолгоо:
- [Maven-ийн гаралт](results/mvn-verify-A.txt)
- [JaCoCo хэмжилт](results/jacoco-A.csv)
