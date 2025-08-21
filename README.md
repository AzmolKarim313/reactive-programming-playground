# Java Reactive Programming Learning Project

Hi, I'm **Md. Azmol Karim** 👋  

Welcome to this project!  
This repository is dedicated to exploring **Java Reactive Programming** in depth.  
The goal is to serve as a learning hub where we can practice and grow together as Java Reactive programmers.  

Along the way, I also integrate **Spring Boot** periodically to demonstrate real-world use cases and practical applications.  

Let’s dive in and learn Reactive Programming step by step 🚀  

---

## 📚 What You'll Learn
- Fundamentals of **Reactive Programming** in Java  
- Working with **Reactor** (Mono, Flux, Operators)  
- Applying backpressure and asynchronous data streams  
- Integrating **Reactive Streams with Spring Boot**  
- Building reactive REST APIs  

---

## ⚙️ Getting Started

### Prerequisites
Make sure you have the following installed:
- **Java 17+**  
- **Maven** or **Gradle**  
- **Spring Boot** (for integration examples)  
- An IDE such as **IntelliJ IDEA** or **Eclipse**  

### Clone the Repository
```bash
git clone https://github.com/AzmolKarim313/reactive-programming-playground.git
cd reactive-programming-playground
```

## 🧩 Learning Sections
### Section 01: Core Reactive Components
- Create a custom Publisher, Subscriber, and Subscription
- Implement their core logic step by step

### Section 02: Exploring Mono
In this section, we dive into the major operations of the Mono publisher.
- Lecture 01: Non-Mono Lazy Operations
- Lecture 02: `Mono.just()`
- Lecture 03: `Mono.subscribe()`
- Lecture 04: `Mono.empty()` & `Mono.error()`
- Lecture 05: `Mono.fromSupplier()`
- Lecture 06: `Mono.fromCallable()`
- Lecture 07: `Mono.fromRunnable()`
- Lecture 08: `Mono.fromFuture()`
- Lecture 10: `Mono.defer()`
- Lecture 11: Non-blocking I/O

### 🎯 Assignment

Create a FileService using Mono that can:
- Read a file
- Write to a file
- Delete a file

All operations must be implemented reactively using Mono.
