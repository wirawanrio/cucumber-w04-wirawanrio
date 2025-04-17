# Cucumber W04 Wirawanrio

Automation Testing Project using **Java**, **Cucumber**, and **Selenium WebDriver**.

# 📄 Link Test Scenario
```
https://docs.google.com/spreadsheets/d/1_jU2BfYjTM63ScDkWjhBMkxIaIAne88vIMTfcKMcrZE/edit?usp=sharing
```

## 📋 Project Overview

Ini adalah project latihan minggu ke-4 yang menggunakan:
- **Java** sebagai bahasa pemrograman
- **Selenium WebDriver** untuk automation browser
- **Cucumber** untuk BDD (Behavior Driven Development)
- **Maven** sebagai build tool
- **Page Object Model (POM)** untuk struktur kode yang lebih rapi

## 🚀 Project Structure

```text
src
└── test
    ├── java
    │   ├── hooks/               # Before after skenario
    │   ├── stepdefinitions/     # Step Definitions untuk Cucumber
    │   ├── runners/             # Test Runner untuk menjalankan test
    └── resources
        └── features/            # File .feature (Gherkin syntax)
```



## ⚙️ Prerequisites

- Java JDK 8 atau lebih baru
- Maven
- IDE seperti IntelliJ IDEA atau Eclipse
- Browser (Chrome) dan WebDriver yang sesuai

## 🛠️ How to Run the Project

1. **Clone repository ini**:
    ```bash
    git clone https://github.com/wirawanrio/cucumber-w04-wirawanrio.git
    cd cucumber-w04-wirawanrio
    ```

2. **Update WebDriver** jika perlu di `utilities/DriverManager.java`.

3. **Run Test**:
    - Langsung dari IDE: klik kanan pada file **TestRunner** → **Run**.

## 📝 Important Notes

- Menggunakan **Driver Singleton Pattern** untuk manajemen WebDriver.
- Menggunakan **Cucumber Hooks** (`@Before`, `@After`) untuk setup dan teardown otomatis.
- Struktur project sudah mengikuti konsep **Page Factory** untuk maintainability.

## 📄 Reports

Setelah test selesai, laporan hasil eksekusi dan screenshot test dapat ditemukan di:
/target/reports/


## ✨ Future Improvements

- Menambahkan **ExtentReports** untuk laporan lebih interaktif.
- Integrasi dengan **CI/CD pipelines** seperti Jenkins atau GitHub Actions.
- Support untuk multiple browsers (Chrome, Firefox, Edge).

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

> Dibuat dengan ❤️ oleh [wirawanrio](https://github.com/wirawanrio)
