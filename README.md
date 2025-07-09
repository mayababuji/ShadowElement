#  Shadow DOM Selenium Checkout Automation

Automated end-to-end test for checkout flow on a Polymer-based shopping site using **Java, Selenium, TestNG**, and **Shadow DOM handling**.

---

##  **Project Overview**

This framework:

- Automates the checkout functionality of the **Polymer Shop Demo**
- Uses **TestNG** for test management and assertions
- Implements **Shadow DOM element access** via `JavascriptExecutor`
- Designed for **cross-browser testing** (Chrome, Firefox, Edge)
- Uses **Page Object Model** for clean maintainable code

---


---

## ⚙️ **Prerequisites**

✅ Java 11+  
✅ Maven 3.6+  
✅ TestNG  
✅ Git  
✅ ChromeDriver, EdgeDriver,FirefoxDriver configured in system PATH or via WebDriverManager (if integrated)

---

## 🔧 **Installation & Running Tests**

1. **Clone the repository**
    ```bash
    git clone https://github.com/yourusername/ShadowDomSelenium.git
    cd ShadowDomSelenium
    ```

2. **Update configuration**

   - Modify `config.properties` under `src/test/resources/Config/` with:
     ```properties
     url=https://shop.polymer-project.org/

     ```

3. **Run tests using Maven**
    ```bash
    mvn clean test
    ```

   Or directly via **TestNG XML**:
    ```bash
    mvn clean test -DsuiteXmlFile=src/test/java/testng.xml
    ```

---

## 💡 **Key Features**

- **Shadow DOM Automation:** Uses `JavascriptExecutor` and Selenium `SearchContext` for deep shadow-root traversal.
- **Parallel Execution:** Configurable using TestNG and ThreadLocal driver.
- **PageFactory Implementation:** Clean separation of locators and test logic.
- **Cross Browser Support:** Chrome, Firefox, Edge.

---

## 📝 **Test Cases Included**

✅ **Navigate to Home Page**  
✅ **Select Men's Outerwear**  
✅ **Add item to cart**  
✅ **Proceed to checkout**

---

## 🔨 **Tools & Technologies**

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Git & GitHub**

---

## 🤝 **Contributing**

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---





