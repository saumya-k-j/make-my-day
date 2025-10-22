# 🌅 Make My Day — Java App (NetBeans / VS Code)

**Make My Day** is a Java prototype that builds **automated daily itineraries** from user preferences, deadlines, and mood.  
It includes login & registration, a dashboard, mood tracking, and deadline management — designed with an emphasis on **user-centric problem solving**.

> 📚 *Originally developed as a school project at Narsee Monjee Educational Trust’s – Jamnabai Narsee School (Sep 2022 – Feb 2023).*

---

## ✨ Features

- **User Authentication** — register, log in, and manage personal sessions  
  *Files:* `Register.java`, `SignIn.java`, `loginPage.java`
- **Dashboard Interface** — view the current day’s plan & quick actions  
  *File:* `Dashboard.java`
- **Mood Tracking** — capture daily mood to bias itinerary generation  
  *File:* `Mood_page.java`
- **Deadline Manager** — store & prioritize tasks by urgency  
  *Files:* `Deadline_page.java`, `Deadline_page.form`
- **Database Integration** — MySQL via JDBC for persistent data  
  *File:* `MySQLConnect.java`
- **GUI Builder Support** — `.form` files from NetBeans (metadata for Swing layouts)

---

## 🗂 Project Structure

MakeMyDay/
├── Dashboard.java
├── Deadline_page.java
├── Deadline_page.form
├── loginPage.java
├── loginPage.form
├── Mood_page.java
├── MySQLConnect.java
├── Register.java
├── SignIn.java
├── SignIn.form
└── (NewFolder/, NewFolder.1/, NewFolder.2/ — additional assets/WIP)

---

## 🛠 Tech Stack

| Layer | Technology |
|-------|-------------|
| **Language** | Java 11 + (OOP) |
| **UI Framework** | Swing / AWT via NetBeans Form Builder |
| **Database** | MySQL (connected through JDBC) |
| **IDE** | NetBeans initially, VS Code compatible |
| **Version Control** | Git + GitHub |

---

## ⚙️ Setup Guide

### 1️⃣ Requirements
- Java JDK 11 or newer (`java -version`)
- MySQL Server (local or cloud)
- VS Code or NetBeans IDE
- Git (for pushing / cloning)

### 2️⃣ Database Setup
Run in your MySQL console:

```sql
CREATE DATABASE makemyday CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE makemyday;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  name VARCHAR(100) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE deadlines (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  due_at DATETIME NOT NULL,
  priority ENUM('low','medium','high') DEFAULT 'medium',
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE mood_log (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  mood ENUM('low','neutral','high') NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

private static final String URL  = "jdbc:mysql://localhost:3306/makemyday";
private static final String USER = "root";
private static final String PASS = "your_password";
