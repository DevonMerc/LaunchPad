<template>
    <div>
        <h1>My unorthodox below, form not finished</h1>
        Thinking a form:
        $ Goal
        Title
        Campaign manager
        Description
        image upload maybe
        radio button for private or public
        dropdown menu for tags set, or its like checkboxes? Gonna struggle with checkbox logic
        submit button
    </div>
    <form>
        <div>
            <label for="goal">Whats the starting goal? </label>
            <input type="number" id="goal" />
        </div>
        <div>
            <label for="goal">Whats the starting goal? </label>
            <input type="number" id="goal" />
        </div>
        <div>
            <label for="goal">Whats the starting goal? </label>
            <input type="number" id="goal" />
        </div>
        <div>
            <label for="goal">Whats the starting goal? </label>
            <input type="number" id="goal" />
        </div>
        <input type="submit" @click="addCampaign"/>
    </form>
</template>

<script>
export default{ 
    methods: {
        addCampaign(){
            //right now it only redirects to the dashboard, gonna add in store stuff later
            this.$router.push({name:'dashboard'});
        }
    }
}
</script>