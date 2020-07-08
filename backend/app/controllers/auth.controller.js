const { firebase, db } = require("../../db/firebase")

async function signIn(req, res) {
    const { email, password } = req.body
    try {
        const auth = await firebase.auth().signInWithEmailAndPassword(email, password)
        const usersRef = db.collection('users')

        try {
            const user = await usersRef.doc(auth.user.uid).get()
            res.send(user.data())
        } catch (error) {
            res.status(400).send(error)
        }

    } catch (error) {
        res.status(400).send(error)
    }
}

async function signUp(req, res) {
    const { email, password, firstName, lastName } = req.body
    try {
        const auth = await firebase.auth().createUserWithEmailAndPassword(email, password)
        const uid = auth.user.uid

        const usersRef = db.collection("users")

        try {
            const user = await usersRef.doc(uid).set({
                name: {
                    first: firstName,
                    last: lastName
                },
                points: 0,
                badges: []
            });
            return res.send(user)
        } catch (error) {
            res.status(400).send(error)
        }
    } catch (error) {
        res.status(400).send(error)
    }
}

module.exports = { signIn, signUp }