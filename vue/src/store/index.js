import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      campaigns: [
        {
          id: 1,
          title: 'Campaign 1', 
          imageUrl: '',
          description: 'Description for Campaign 1',
          tags: [
            'Health','Education','Charity'
          ], 
          fundingGoal: 100,
          endDate: '2024-01-01',
          campaignManager: "Tom", 
          fundsRaised: 0,
          isPublic: false
        },
        {
          id: 2,
          title: 'Campaign 2', 
          imageUrl: '',
          description: 'Description for Campaign 2',
          tags: [
            'Technology','Arts'
          ], 
          fundingGoal: 4360,
          endDate: '2024-01-01',
          campaignManager: "Mary", 
          fundsRaised: 0,
          isPublic: true
        },
        {
          id: 3,
          title: 'Campaign 3', 
          imageUrl: '',
          description: 'Description for Campaign 3',
          tags: [
            'Charity'
          ], 
          fundingGoal: 660,
          endDate: '2024-01-01',
          campaignManager: "Shanon", 
          fundsRaised: 0,
          isPublic: false
        },
        {
          id: 4,
          title: 'Campaign 4', 
          imageUrl: '',
          description: 'Description for Campaign 4',
          tags: [
            'Environment','Charity'
          ], 
          fundingGoal: 87400,
          endDate: '2024-01-01',
          campaignManager: "Alex", 
          fundsRaised: 0,
          isPublic: true
        },
        {
          id: 5,
          title: 'Campaign 5', 
          imageUrl: '',
          description: 'Description for Campaign 5',
          tags: [
            'Education'
          ], 
          fundingGoal: 100,
          endDate: '2024-01-01',
          campaignManager: "Percy", 
          fundsRaised: 0,
          isPublic: true
        },
        {
          id: 6,
          title: 'Campaign 6', 
          imageUrl: '',
          description: 'Description for Campaign 6',
          tags: [
            'Business','Education'
          ], 
          fundingGoal: 100,
          endDate: '2024-01-01',
          campaignManager: "Lorain", 
          fundsRaised: 0,
          isPublic: true
        }

      ]
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
  });
  return store;
}
