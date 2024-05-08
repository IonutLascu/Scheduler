# Scheduler App

## Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- Node.js
- Yarn Package Manager
- Docker (for running the infrastructure)

## Getting Started

1. **Clone the Repository**: Clone this repository to your local machine.

    ```bash
    git clone https://github.com/IonutLascu/Scheduler.git
    ```

2. **Navigate to the Project Directory**: Enter the project directory.

    ```bash
    cd Scheduler
    ```

3. **Install Dependencies**: Use Yarn to install project dependencies.

    ```bash
    yarn install
    ```

4. **Set Up Infrastructure**: Start the Docker containers for the infrastructure.

    ```bash
    yarn infra:up
    ```
5. **Building and Running Server**

  ```bash
  ./gradlew build
   java -jar build/libs/Scheduler-0.0.1-SNAPSHOT.jar
  ```

