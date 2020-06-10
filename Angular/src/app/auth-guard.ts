import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';


@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    canActivate(route: ActivatedRouteSnapshot): boolean {
        const expectedLoginTypeArray = route.data.expectedLoginTypes;
        const userDetails = JSON.parse(localStorage.getItem('details'));
        let expectedLoginType: string;
        for (const index in expectedLoginTypeArray) {
            if (userDetails && userDetails.loginType === expectedLoginTypeArray[index]) {
                expectedLoginType = expectedLoginTypeArray[index];
            }
        }
        if (userDetails && userDetails.loginType === expectedLoginType) {
            return true;
        } else {
            return false;
        }
    }
}
