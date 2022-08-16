
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { finalize, Observable } from "rxjs";
import { Injectable } from "@angular/core";

@Injectable()
export class CustomIntereptor implements HttpInterceptor
{
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        if(req.url.indexOf('api/login/')==-1)
        {
            req=req.clone({
                headers:req.headers.set('Authorization','Bearer '+localStorage.getItem('soccer-bill-token'))
            })
        }
        return next.handle(req).pipe(
            finalize(() => console.log())
          );
    }
    
}