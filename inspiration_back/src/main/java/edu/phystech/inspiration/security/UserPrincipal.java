package edu.phystech.inspiration.security;

import java.util.List;

import edu.phystech.inspiration.data.Story;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class UserPrincipal implements UserDetails {
  private Long id;
  private String username;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  public UserPrincipal(Long id, String username, String password,
                       List<Story> stories) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.authorities = stories.stream()
        .map(role -> new SimpleGrantedAuthority("STORY_" + role.getName())).toList();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

}
