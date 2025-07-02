Now that you have a streamsets account and have successfully accessed the StreamSets Control Hub portal, the next step is to deploy your engine to your virtual machine (VM). In this workshop, you will be provided with a TechZone VM environment for this purpose.

#### Streamsets Portal

1. **Create deployment on streamsets**
   - Go to the deployment tab and create a deployment
   <img width="1280" alt="image" src="https://github.com/user-attachments/assets/5cb6727b-7f0f-40ff-a92e-c0d5c703b3c1" />

   - Put deployment with `workshop_streamsets_deployment`
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/24d1563c-57ce-45ab-82eb-c49aad24d77c" />

   - In engine labels, put `workshop_streamsets`
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/23181402-ed16-4691-a1ae-44b8654996a2" />

   - Here, you can share your deployment with specific emails that you have already set on the `Manage/Users` tab
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/7899cd84-122d-4ae5-9d50-96e36595ff38" />

   - After reviewing, click start and generate install scripts
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/1d901333-95d7-4924-96fa-e4270d76544a" />

   - Please keep and save the script of the installation, then exit
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/4a22cb78-41a4-455a-9177-db5d39dcbca2" />

   - In the Deployments tab, you can see that your deployment is ready. However, in the Engines tab, the engine has not been registered yet.
     <img width="1280" alt="image" src="https://github.com/user-attachments/assets/c0471848-632e-4b03-b222-b56023c062d2" />

---
In order to create the engine, you need a VM to deploy it on. In this workshop, the VM has been provisioned for you by the instructors through TechZone.

#### Virtual Machine Portal

2. **Create engine on streamsets**
   - Go to `https://techzone.ibm.com/my/reservations` and make sure your reservation card is visible and open the environment
   <img width="1281" alt="image" src="https://github.com/user-attachments/assets/dc24a836-1708-4a1d-b526-06bc9752581e" />

   - Scroll down and open the console
   <img width="1281" alt="image" src="https://github.com/user-attachments/assets/f0127fba-338a-447f-a5d9-5ccbe56bdf00" />

   - Log in as an admin and put the password `IBMDem0s`
   <img width="1281" alt="image" src="https://github.com/user-attachments/assets/788fc18d-6dd7-4be6-953e-be2269e2f69c" />

   - Go to streamsets folder and copy and paste the script in step 1 to deploy the engine (using the toggle)
   <img width="1281" alt="image" src="https://github.com/user-attachments/assets/fa498f46-3fe7-4326-b999-c1316b2804a0" />
   
   - Put the streamsets data collector download in sdc-download and streamsets data collector in sdc
   <img width="1281" alt="image" src="https://github.com/user-attachments/assets/4b7bc6d0-53c8-40fa-b9e7-db0127221598" />
   
   - Wait for a couple of minutes until you see the message `Engine started successfully`
   <img width="1281" alt="image" src="https://github.com/user-attachments/assets/14b4d7dc-ea31-47c3-8b38-2a1d4479e5e3" />
   
---

#### Streamsets Portal
Back to the streamsets portal and check the engine

3. **Check the engine**
   - Before the deployment in the VM
   <img width="1281" alt="image" src="https://github.com/user-attachments/assets/8f052894-d096-4437-96b7-0ad2d50db254" />

   - After the deployment in the VM
   <img width="1281" alt="image" src="https://github.com/user-attachments/assets/afd2bca7-af56-4344-ad80-8d1f941b674b" />

---