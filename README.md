# 🛒 E-Commerce System in Java (OOP-Based)

This is a simple object-oriented e-commerce system implemented in Java.  
The system models real-world e-commerce components such as Products, Customers, Cart, Checkout, and Shipping.

---

## 📦 Features

- ✅ Define products with name, price, and quantity
- ⏳ Support perishable (expiring) and non-perishable products
- 🚚 Handle shippable and non-shippable products
- 🛍️ Allow customers to add items to cart with quantity check
- 💳 Perform checkout with:
  - Subtotal calculation
  - Shipping fees
  - Payment & balance deduction
  - Error handling for out-of-stock, expired products, insufficient balance
- 📦 Ship items using `ShippingService` with weight-based cost
- 🔍 Object-Oriented Design with abstraction, inheritance, and interfaces

---

## 📁 Project Structure

```bash
ecommerce-system/
├── src/
│   ├── Product.java
│   ├── Expire.java
│   ├── NonExpire.java
│   ├── Shippable.java
│   ├── ShippableItem.java
│   ├── CartItem.java
│   ├── Cart.java
│   ├── Customer.java
│   ├── ShippingService.java
│   ├── CheckoutService.java
│   └── App.java
└── README.md
![image alt](https://github.com/SamehYousry/FawryEcommerceTask/blob/main/uml.png?raw=true)
