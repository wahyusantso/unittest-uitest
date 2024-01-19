package com.home.belajartesting

/*
- JUnit digunakan untuk melakukan unit test, sedangkan Mockito digunakan sebagai mock object.
  Fungsi dari mock object adalah mereplika objek yang digunakan oleh objek yang sedang di-test.
  Tujuannya agar test yang dilakukan hanya dilakukan pada unit yang berada dalam jangkauan objek yang sedang di-test tanpa memengaruhi objek di luar jangkauan.

- Manfaat Penggunaan Mocking
  Menghindari Terlalu Banyak Dependency. Mocking mengurangi ketergantungan fungsi.
  Misalnya, jika Anda memiliki fungsi Kelas yang bergantung pada fungsi B, tulislah beberapa unit test yang mencakup fitur yang diberikan oleh fungsi B.
  Misalkan kode itu berkembang di masa depan dan Anda memiliki lebih banyak fungsi, yaitu A tergantung pada B, B bergantung pada C, dan C bergantung pada D. Jika kesalahan dikenalkan pada Z, semua unit test Anda akan gagal.

- Annotation
  @Before
  Fungsinya untuk menginisialisasi method sebelum melakukan test.
  Method yang diberi anotasi @Before ini akan dijalankan sebelum menjalankan semua method dengan anotasi @Test.
  Selain anotasi @Before, dalam melakukan Unit Test juga ada anotasi @After yang berfungsi sebaliknya dari anotasi @Before, yaitu untuk menginisialisai method yang akan dijalankan setelah method dengan anotasi @Test.
  @Test
  Anotasi ini digunakan pada method yang akan dites.

- Fungsi yang terdapat dalam test
  mock()
  Fungsinya untuk membuat obyek mock yang akan menggantikan obyek yang asli.
  when()
  Digunakan untuk menandakan event di mana Anda ingin memanipulasi behavior dari mock object.
  thenReturn()
  Digunakan untuk memanipulasi output dari mock object.
  verify()
  Digunakan untuk memeriksa metode dipanggil dengan arguman yang diberikan. Verify merupkan fungsi dari framework Mockito
  assertEquals()
  Fungsi ini merupakan fungsi dari JUnit yang digunakan untuk memvalidasi output yang diharapkan dan output yang sebenarnya.
 **/