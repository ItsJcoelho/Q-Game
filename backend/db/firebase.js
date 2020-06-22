require("dotenv").config()
const firebase = require("firebase/app")
const admin = require("firebase-admin")

// Add the Firebase products that you want to use
require("firebase/auth")
require("firebase/firestore")

const firebaseConfig = {
    apiKey: process.env.firebaseApiKey,
    authDomain: process.env.firebaseAuthDomain,
    databaseURL: process.env.firebaseDatabaseURL,
    projectId: process.env.firebaseProjectId,
    storageBucket: process.env.firebaseStorageBucket,
    messagingSenderId: process.env.firebaseMessagingSenderId,
    appID: process.env.firebaseAppID,
}

firebase.initializeApp(firebaseConfig)


const serviceAccount = require("./serviceAccount.json");

admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
    databaseURL: "https://qgame-2e75d.firebaseio.com"
});

let db = admin.firestore()

module.exports = { firebase, db }