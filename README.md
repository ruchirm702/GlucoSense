# GlucoSense

![GlucoSense](https://img.shields.io/badge/GlucoSense-Diabetes%20Management-87CEEB?style=for-the-badge&logo=medical&logoColor=white)  
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)  
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)  
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)  
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)


Welcome to **GlucoSense**—a comprehensive diabetes management system designed to streamline patient care and enhance health management. With a focus on various aspects of diabetes care, GlucoSense provides a robust foundation for managing patient information, medical records, and user interactions.

## Architecture Overview

### Monolithic Architecture

GlucoSense uses a monolithic architecture, integrating all functionalities into a single application. The entire system—comprising modules like PatientService, UserService, and BillingService—is developed, deployed, and maintained as one unit.

## 🏗️ Project Overview

Check out the project overview and design on Canva: [GlucoSense Overview](https://www.canva.com/design/DAGOmR3J8BQ/x3CpsySueyD8Ahk1FvYZlA/view?utm_content=DAGOmR3J8BQ&utm_campaign=designshare&utm_medium=link&utm_source=editor)



## 🚀 Key Features

1. **Patient Management**
   - **Patient Profiles:** Manage detailed patient profiles including personal information, medical history, and contact details.
   - **Medical Records:** Track and manage patients' medical records, including lab results, medications, measurements, and blood sugar records.
   - **Consultations:** Manage and record consultations between patients and doctors.

2. **User Management**
   - **User Authentication:** Handle user authentication and authorization.
   - **Role Management:** Define and manage different user roles and permissions.
   - **User Status:** Track and manage user status (e.g., active, inactive).

3. **Doctor Management**
   - **Doctor Profiles:** Manage doctor profiles including specialties, affiliations, and roles.
   - **Consultations:** Record and manage consultations involving doctors.

4. **Feedback Collection**
   - **Feedback Management:** Collect and manage feedback from patients about their experiences with consultations, doctors, and overall service quality.
   - **Feedback Filtering:** Retrieve feedback based on specific targets, such as consultations or doctors.

5. **Medical Records Management**
   - **Lab Results:** Manage and track lab test results for patients.
   - **Blood Sugar Records:** Monitor and manage blood sugar levels recorded over time.
   - **Medication Management:** Handle prescribed medications and track medication adherence.
   - **Activity Records:** Record and track patient activities and their impact on health.
   - **Diet Entries:** Manage and monitor patients' dietary information.

6. **Emergency Contact Management**
   - **Emergency Contacts:** Manage emergency contact information for patients.

7. **Device Management**
   - **Device Tracking:** Manage medical devices used by patients for health monitoring.

8. **Appointments**
   - **Appointment Scheduling:** Manage and schedule appointments between patients and doctors.

9. **Billing and Payment**
   - **Billing:** Handle billing information related to patient services.
   - **Payments:** Manage payment records and transactions.

10. **Insurance Management**
    - **Insurance Records:** Manage and track patient insurance information and claims.

11. **Notifications**
    - **Alerts and Reminders:** Send notifications related to appointments, medication, and other important updates.

12. **Reports**
    - **Generate Reports:** Create and manage various reports related to patient care, medical records, and feedback.

13. **Prescription Management**
    - **Manage Prescriptions:** Handle and track patient prescriptions and ensure adherence.

14. **General Features**
    - **CRUD Operations:** Full support for Create, Read, Update, and Delete operations on core entities.
    - **Exception Handling:** Comprehensive exception handling to manage errors and maintain system integrity.
    - **DTO Mapping:** Use Data Transfer Objects (DTOs) for transferring data between different layers of the application.

## 🏗️ Project Structure

GlucoSense is organized into a monolithic architecture with a clear separation of concerns. Here's the structure:

```plaintext
glucosense
├── config
├── controller
├── controller_advise
│   ├── Custom_Exceptions
│   ├── Standard_Exceptions
│   ├── ErrorResponse
│   └── GlobalExceptionHandler
├── model
│   ├── Core
│   ├── Enum
│   └── support
├── dto
│   ├── Support_dto
│   ├── Enum_dto
│   └── Core_Dto
├── repository
└── service
    ├── Implementation
    └── Interface
```
# 🛠️ Services Overview

GlucoSense includes several key services, each responsible for different aspects of the system:

## PatientService
- **Description:** Manages patient records, including personal details and medical history.
- **Endpoints:**
  - **Create Patient:** `POST /api/patients`
  - **Update Patient:** `PUT /api/patients/{id}`
  - **Delete Patient:** `DELETE /api/patients/{id}`
  - **Get Patient by ID:** `GET /api/patients/{id}`
  - **Get All Patients:** `GET /api/patients`

## UserService
- **Description:** Handles user management and authentication, including roles and statuses.
- **Endpoints:**
  - **Create User:** `POST /api/users`
  - **Update User:** `PUT /api/users/{id}`
  - **Delete User:** `DELETE /api/users/{id}`
  - **Get User by ID:** `GET /api/users/{id}`
  - **Get All Users:** `GET /api/users`

## DoctorService
- **Description:** Manages doctor profiles and consultations.
- **Endpoints:**
  - **Create Doctor:** `POST /api/doctors`
  - **Update Doctor:** `PUT /api/doctors/{id}`
  - **Delete Doctor:** `DELETE /api/doctors/{id}`
  - **Get Doctor by ID:** `GET /api/doctors/{id}`
  - **Get All Doctors:** `GET /api/doctors`

## ConsultationService
- **Description:** Manages consultations between patients and doctors.
- **Endpoints:**
  - **Create Consultation:** `POST /api/consultations`
  - **Update Consultation:** `PUT /api/consultations/{id}`
  - **Delete Consultation:** `DELETE /api/consultations/{id}`
  - **Get Consultation by ID:** `GET /api/consultations/{id}`
  - **Get All Consultations:** `GET /api/consultations`

## LabResultService
- **Description:** Handles lab test results.
- **Endpoints:**
  - **Create Lab Result:** `POST /api/labresults`
  - **Update Lab Result:** `PUT /api/labresults/{id}`
  - **Delete Lab Result:** `DELETE /api/labresults/{id}`
  - **Get Lab Result by ID:** `GET /api/labresults/{id}`
  - **Get All Lab Results:** `GET /api/labresults`

## BloodSugarRecordService
- **Description:** Manages blood sugar records.
- **Endpoints:**
  - **Create Blood Sugar Record:** `POST /api/bloodsugarrecords`
  - **Update Blood Sugar Record:** `PUT /api/bloodsugarrecords/{id}`
  - **Delete Blood Sugar Record:** `DELETE /api/bloodsugarrecords/{id}`
  - **Get Blood Sugar Record by ID:** `GET /api/bloodsugarrecords/{id}`
  - **Get All Blood Sugar Records:** `GET /api/bloodsugarrecords`

## MedicationService
- **Description:** Handles prescribed medications.
- **Endpoints:**
  - **Create Medication:** `POST /api/medications`
  - **Update Medication:** `PUT /api/medications/{id}`
  - **Delete Medication:** `DELETE /api/medications/{id}`
  - **Get Medication by ID:** `GET /api/medications/{id}`
  - **Get All Medications:** `GET /api/medications`

## MeasurementService
- **Description:** Manages patient measurements.
- **Endpoints:**
  - **Create Measurement:** `POST /api/measurements`
  - **Update Measurement:** `PUT /api/measurements/{id}`
  - **Delete Measurement:** `DELETE /api/measurements/{id}`
  - **Get Measurement by ID:** `GET /api/measurements/{id}`
  - **Get All Measurements:** `GET /api/measurements`

## ActivityRecordService
- **Description:** Records patient activities.
- **Endpoints:**
  - **Create Activity Record:** `POST /api/activityrecords`
  - **Update Activity Record:** `PUT /api/activityrecords/{id}`
  - **Delete Activity Record:** `DELETE /api/activityrecords/{id}`
  - **Get Activity Record by ID:** `GET /api/activityrecords/{id}`
  - **Get All Activity Records:** `GET /api/activityrecords`

## DietEntryService
- **Description:** Manages diet-related data.
- **Endpoints:**
  - **Create Diet Entry:** `POST /api/dietentries`
  - **Update Diet Entry:** `PUT /api/dietentries/{id}`
  - **Delete Diet Entry:** `DELETE /api/dietentries/{id}`
  - **Get Diet Entry by ID:** `GET /api/dietentries/{id}`
  - **Get All Diet Entries:** `GET /api/dietentries`

## EmergencyContactService
- **Description:** Manages emergency contact information.
- **Endpoints:**
  - **Create Emergency Contact:** `POST /api/emergencycontacts`
  - **Update Emergency Contact:** `PUT /api/emergencycontacts/{id}`
  - **Delete Emergency Contact:** `DELETE /api/emergencycontacts/{id}`
  - **Get Emergency Contact by ID:** `GET /api/emergencycontacts/{id}`
  - **Get All Emergency Contacts:** `GET /api/emergencycontacts`

## DeviceService
- **Description:** Manages medical devices.
- **Endpoints:**
  - **Create Device:** `POST /api/devices`
  - **Update Device:** `PUT /api/devices/{id}`
  - **Delete Device:** `DELETE /api/devices/{id}`
  - **Get Device by ID:** `GET /api/devices/{id}`
  - **Get All Devices:** `GET /api/devices`

## AppointmentService
- **Description:** Manages appointment scheduling.
- **Endpoints:**
  - **Create Appointment:** `POST /api/appointments`
  - **Update Appointment:** `PUT /api/appointments/{id}`
  - **Delete Appointment:** `DELETE /api/appointments/{id}`
  - **Get Appointment by ID:** `GET /api/appointments/{id}`
  - **Get All Appointments:** `GET /api/appointments`

## PrescriptionService
- **Description:** Handles prescription records.
- **Endpoints:**
  - **Create Prescription:** `POST /api/prescriptions`
  - **Update Prescription:** `PUT /api/prescriptions/{id}`
  - **Delete Prescription:** `DELETE /api/prescriptions/{id}`
  - **Get Prescription by ID:** `GET /api/prescriptions/{id}`
  - **Get All Prescriptions:** `GET /api/prescriptions`

## BillingService
- **Description:** Manages billing and payment information.
- **Endpoints:**
  - **Create Billing:** `POST /api/billings`
  - **Update Billing:** `PUT /api/billings/{id}`
  - **Delete Billing:** `DELETE /api/billings/{id}`
  - **Get Billing by ID:** `GET /api/billings/{id}`
  - **Get All Billings:** `GET /api/billings`

## InsuranceService
- **Description:** Handles insurance information.
- **Endpoints:**
  - **Create Insurance:** `POST /api/insurances`
  - **Update Insurance:** `PUT /api/insurances/{id}`
  - **Delete Insurance:** `DELETE /api/insurances/{id}`
  - **Get Insurance by ID:** `GET /api/insurances/{id}`
  - **Get All Insurances:** `GET /api/insurances`

## NotificationService
- **Description:** Manages notifications.
- **Endpoints:**
  - **Create Notification:** `POST /api/notifications`
  - **Update Notification:** `PUT /api/notifications/{id}`
  - **Delete Notification:** `DELETE /api/notifications/{id}`
  - **Get Notification by ID:** `GET /api/notifications/{id}`
  - **Get All Notifications:** `GET /api/notifications`

## ReportService
- **Description:** Generates various reports.
- **Endpoints:**
  - **Create Report:** `POST /api/reports`
  - **Update Report:** `PUT /api/reports/{id}`
  - **Delete Report:** `DELETE /api/reports/{id}`
  - **Get Report by ID:** `GET /api/reports/{id}`
  - **Get All Reports:** `GET /api/reports`

## PaymentService
- **Description:** Manages payment transactions.
- **Endpoints:**
  - **Create Payment:** `POST /api/payments`
  - **Update Payment:** `PUT /api/payments/{id}`
  - **Delete Payment:** `DELETE /api/payments/{id}`
  - **Get Payment by ID:** `GET /api/payments/{id}`
  - **Get All Payments:** `GET /api/payments`

## FeedbackService
- **Description:** Collects and manages feedback.
- **Endpoints:**
  - **Create Feedback:** `POST /api/feedback`
  - **Update Feedback:** `PUT /api/feedback/{id}`
  - **Delete Feedback:** `DELETE /api/feedback/{id}`
  - **Get Feedback by ID:** `GET /api/feedback/{id}`
  - **Get All Feedbacks:** `GET /api/feedback`
  - **Get Feedback by Target:** `GET /api/feedback/target/{targetEntityType}/{targetEntityId}`

![Logo](https://www.canva.com/design/DAGOmR3J8BQ/x3CpsySueyD8Ahk1FvYZlA/view?utm_content=DAGOmR3J8BQ&utm_campaign=designshare&utm_medium=link&utm_source=editor)

