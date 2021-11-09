package com.zuhaib.FinalCaseAxis.model

import org.springframework.security.core.GrantedAuthority

class Authority(private val authority: String?) : GrantedAuthority {
    override fun getAuthority(): String? {
        return authority
    }

}
