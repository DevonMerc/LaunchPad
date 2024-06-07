<template>
    <div v-if="campaign.pic">
        <img src="../assets/Launchpad-logo-full.png" alt="Launchpad Logo">
    </div>
    <div>
        <h1>Campaign Request Form</h1>
    </div>
    <div class="form-container">
        <form>
            <div class="form-group">
                <input type="text" id="title" name="title" placeholder="Title of Campaign" required>
            </div>
            <div class="form-group">
                <input type="text" id="request" name="request" placeholder="Campaign Request" required>
            </div>
            <div class="form-group">
                <input type="text" id="manager" name="manager" placeholder="Campaign Manager" required>
            </div>
            <div class="form-group">
                <input type="text" id="description" name="description" placeholder="Description Request" required>
            </div>
            <button type="submit" class="submit-btn">Create Request</button>
        </form>
    </div>
</template>
  
<script>

</script>
  
<style>
</style>