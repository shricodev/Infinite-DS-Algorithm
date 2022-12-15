// package SlidingWindow.Variable;
// this is jsut the pseudo code or the general format of the variable sliding window.

// while (j < n) {
//     calculations

//     if (condn < k) {
//         j++
//     } else if (condn == k) {
//         ans calculations
//         j++;
//      since we are not maintaining the size k variable so there can be the greater case and we should handle it as well. 
//     } else if (condn > k) {
//         while (condn > k) {
//             remove calculations for i
//             i++;
//         }
//         if (condn == k) {
//              calculate ans;
//         }
//         j++;
//     }
//     return ans;
// }